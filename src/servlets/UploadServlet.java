package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4208297154247875627L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeys = blobs.get("data");
		if (blobKeys == null || blobKeys.isEmpty()) {
			resp.sendRedirect("/vraag-uploaden.jsp");
		} else {		
			resp.sendRedirect("/serve?blob-key="
					+ blobKeys.get(0).getKeyString());
		}
	}
}
