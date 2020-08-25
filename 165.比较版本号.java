/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        do {
            Version v1 = nextVersion(version1);
            Version v2 = nextVersion(version2);

            if (v1.versionCode > v2.versionCode) {
                return 1;
            } else if (v1.versionCode < v2.versionCode) {
                return -1;
            } else {
                if (v1.version.length() == 0 && v2.version.length() == 0) {
                    return 0;
                } else {
                    version1 = v1.version;
                    version2 = v2.version;
                }
            }
        } while (true);
    }

    public Version nextVersion(String version) {
        if (version == null || version.length() == 0) return new Version();

        Version ver = new Version();

        for (int i = 0; i < version.length(); ++i) {
            if (version.charAt(i) == '.') {
                ver.version = version.substring(i + 1, version.length());
                break;
            } else {
                if (i == version.length() - 1) {
                    ver.version = "";
                }
                ver.versionCode = ver.versionCode * 10 + Integer.parseInt(version.charAt(i) + "");
            }
        }
        return ver;
    }

    public class Version {
        public String version = "";
        public int versionCode = 0;
    }
}
// @lc code=end

