package com.cts.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class NgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;

	public NgUpload() {
		System.out.println("Inside Servlet Constructor");
	}

	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute(
				"FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/*
		 * System.out.println("Context Type: " + req.getContentType());
		 * 
		 * System.out.println("inside servlet Post method");
		 * 
		 * System.out.println(req.getParameter("file"));
		 * System.out.println(req.getParameter("customer"));
		 * 
		 * res.setStatus(200);
		 */

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException(
					"Content type is not multipart/form-data");
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while (fileItemsIterator.hasNext()) {
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName=" + fileItem.getFieldName());
				System.out.println("FileName=" + fileItem.getName());
				System.out.println("ContentType=" + fileItem.getContentType());
				System.out.println("Size in bytes=" + fileItem.getSize());

				File file = new File(request.getServletContext().getAttribute(
						"FILES_DIR")
						+ File.separator + fileItem.getName());
				System.out.println("Absolute Path at server="
						+ file.getAbsolutePath());
				fileItem.write(file);
				System.out.println("File " + fileItem.getName()
						+ " uploaded successfully.");
				System.out
						.println("<a href=\"UploadDownloadFileServlet?fileName="
								+ fileItem.getName()
								+ "\">Download "
								+ fileItem.getName() + "</a>");
			}
		} catch (FileUploadException e) {
		} catch (Exception e) {
		}
	}
}
