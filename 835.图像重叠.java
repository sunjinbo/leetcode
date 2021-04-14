/*
 * @lc app=leetcode.cn id=835 lang=java
 *
 * [835] 图像重叠
 */

// @lc code=start
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int[][] exImg = extendImg(img1);

        int height = img1.length;
        int width = img1[0].length;

        int largest = 0;
        for (int i = 0; i < height * 2 - 1; ++i) {
            for (int j = 0; j < width * 2 - 1; ++j) {
                int overlap = getOverlap(exImg, img2, j, i);
                if (overlap > largest) {
                    largest = overlap;
                }
            }
        }
        return largest;
    }

    public int getOverlap(int[][] exImg, int[][] img, int startX, int startY) {
        int height = img.length;
        int width = img[0].length;

        int overlap = 0;
        for (int i = startY; i < height + startY; ++i) {
            for (int j = startX; j < width + startX; ++j) {
                if (exImg[i][j] == 1 && img[i - startY][j - startX] == 1) {
                    overlap++;
                }
            }
        }
        return overlap;
    }

    public int[][] extendImg(int[][] img) {
        int height = img.length;
        int width = img[0].length;

        int exHeight = height + (height - 1) * 2;
        int exWidth = width + (width - 1) * 2;

        if (exHeight == height && exWidth == width) {
            return img;
        }

        int[][] exImg = new int[exHeight][exWidth];
        for (int i = height - 1; i < height * 2 - 1; ++i) {
            for (int j = width - 1; j < width * 2 - 1; ++j) {
                exImg[i][j] = img[i - height + 1][j - width + 1];
            }
        }

        return exImg;
    }
}
// @lc code=end

