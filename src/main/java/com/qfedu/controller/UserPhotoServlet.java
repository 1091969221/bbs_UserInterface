package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.impl.PhotoServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/UserPhotoServlet")
public class UserPhotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        File fullFile = null;//存放构造的文件（图片）名

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userid = user.getUserid();
        String pa = getServletContext().getRealPath("/");
        pa = pa.substring(0,pa.indexOf("\\.")).replace("\\","/");
        String th = request.getContextPath().replace("\\", "/");
        String uploadPath = (pa + th) + "/picture/uploda";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart == true) {
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
                Iterator<FileItem> itr = items.iterator();

                // 改写格式
                Date date = new Date();
                String time = date.toLocaleString();
                time = time.replace(" ", "_");
                time = time.replace("-", "_");
                time = time.replace(":", "_");

                while (itr.hasNext()) {// 依次处理每个文件
                    FileItem item = (FileItem) itr.next();
                    String fileName = item.getName();// 获得文件名，包括路径
                    if (fileName != null) {

                        fullFile = new File(time +"_id"+ userid+"_" + item.getName());
                        File savedFile = new File(uploadPath, fullFile.getName());
                        item.write(savedFile);
                    }
                }

                System.out.println("上传成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("enctype必须是 multipart/form-data");
        }
        PhotoServiceImpl photoService = new PhotoServiceImpl();
        Map<Object, Object> map= photoService.query(userid);
        if(null==map.get("photo")) {
            /*将头像信息插入数据库*/
            photoService.save(userid, fullFile.getName());
            System.out.println("进行了头像首次插入");
        }else {
            /*修改头像信息*/
            photoService.update(userid, fullFile.getName());
            System.out.println("进行了头像修改");
        }

        response.sendRedirect("myself/mycenter.jsp");


    }
}
