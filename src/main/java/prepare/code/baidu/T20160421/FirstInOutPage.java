package prepare.code.baidu.T20160421;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FirstInOutPage {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int countCacheMiss(int max_cache_size, int[] page_requests) {
		// INSERT YOUR CODE HERE
		int returnI = 0;
		int[][] page = new int[max_cache_size][2];
		for (int x1 = 0; x1 < max_cache_size; x1++) {

				page[x1][0] = -1;
				page[x1][1] = 0;
			
		}
		for (int i = 0; i < page_requests.length; i++) {

			boolean flag = false;
			for (int j = 0; j < max_cache_size; j++) {
//				System.out.println(i+" cache search:"+page_requests[i] +":"+ page[j][0]);
				if (page_requests[i] == page[j][0]) {
					flag = true;
					for (int k = 0; k < max_cache_size; k++) {
						page[k][1] += 1;
					}
//					page[j][1] = 0;
//					System.out.println("OK"+j+" cache:"+page_requests[i]);
					break;
				}
				

			}
//			System.out.println(i+":"+page_requests[i]);
			if (flag == false) {

				returnI = returnI + 1;
				int max = 0;
				int maxK = 0;
				for (int k = 0; k < max_cache_size; k++) {
					if (page[k][1] > max) {
						max = page[k][1];
						maxK = k;
					}
				}
				for (int k = 0; k < max_cache_size; k++) {
					page[k][1] += 1;
				}
				page[maxK][0] = page_requests[i];
				page[maxK][1] = 0;
//				System.out.println("tihuan:"+maxK+":"+page[maxK][0]+":"+page_requests[i]);

			}
//			System.out.println("End:"+i + ":" + flag + " returnI:" + returnI);
		}

		// System.out.println(page[0][1]);
		// System.out.println(page[1][1]);
		// System.out.println(page[2][1]);
		// System.out.println(page[3][1]);
		return returnI;
	}
	// METHOD SIGNATURE ENDS
}