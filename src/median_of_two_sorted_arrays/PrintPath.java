package median_of_two_sorted_arrays;

/**
 * Created by gavingeng on 2018-06-04 16:29.
 */
public class PrintPath {

	public static String getPath(String path) {
		if (path != null && path.equals("")) {
			return "";
		}

		String[] strs = path.split("\\/");
		String[] ret = new String[strs.length];
		int idx = 0;

		for (String str : strs) {
			if (str.equals("..")) {
				idx--;
				if (idx < 0) idx = 0;
				continue;
			}

			if (str.equals(".") || str.equals("")) {
				continue;
			}

			ret[idx++] = str;
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < idx; i++) {
			buffer.append("/" + ret[i]);
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		String path = "/a/b/./././c/d";
		path = "/../../../../c";
		path = getPath(path);
		System.out.println(path);
	}
}
