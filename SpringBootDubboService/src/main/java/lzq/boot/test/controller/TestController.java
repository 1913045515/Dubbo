package lzq.boot.test.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class TestController {
	@RequestMapping("formTest")
	public String formTest(){
		return "/test";
	}
	
	@PostMapping("/imageUpload")
//	@ModelAttribute
	//HttpServletRequest request, HttpServletResponse response
	public String imageUpload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, FileUploadException {
		Map<String, Object> result = new HashMap<String, Object>();
//		try {
//			request.setCharacterEncoding("utf-8");// 防止中文名乱码
//			int sizeThreshold = 1024 * 6; // 缓存区大小
//			String basePath = "path/";
//			File repository = new File(basePath); // 缓存区目录
//			long sizeMax = 1024 * 1024 * 2;// 设置文件的大小为2M
//			final String allowExtNames = "jpg,gif,bmp,rar,rar,txt,docx,png";
//			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//			diskFileItemFactory.setRepository(repository);
//			diskFileItemFactory.setSizeThreshold(sizeThreshold);
//			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//			servletFileUpload.setSizeMax(sizeMax);
////			servletFileUpload.parseRequest(request);
//			 List<FileItem> fileItems  = servletFileUpload.parseRequest(request);
//				for (FileItem fileItem : fileItems) {
//					System.out.println(fileItem.getName());
//				}
//			System.out.println(servletFileUpload);
			// FileItemFactory factory = new
			// DiskFileItemFactory(Constant.SIZE_THRESHOLD,new
			// File(tempDirectory));
			// ServletFileUpload upload = new ServletFileUpload(factory);
			// // 保存文件路径
			// if (!ServletFileUpload.isMultipartContent(request)) {
			// return null;
			// }
			// DiskFileItemFactory dff = new DiskFileItemFactory();
			//
			// dff.setSizeThreshold(1024000);
			// ServletFileUpload sfu = new ServletFileUpload(dff);
			// FileItemIterator fii = sfu.getItemIterator(request);
			// // 上传状态
			// String state = "SUCCESS";
			// Map<String, String> params = new HashMap<String, String>();
			// while (fii.hasNext()) {
			// System.out.println("fii:"+fii);
			// FileItemStream fis = fii.next();
			// InputStream in = fis.openStream();
			// if (fis.isFormField() || fis.getName().length() == 0) {
			// /*
			// * 文件信息
			// */
			// String value = null;
			// byte c[] = new byte[100];
			// int n = 0;
			// while ((n = in.read(c)) != -1) {
			// value = new String(c, 0, n, "UTF-8");
			// break;
			// }
			// params.put(fis.getFieldName(), value);
			// } else {
			// /*
			// * 文件主体
			// */
			// String fileName = fis.getName();
			// Pattern reg = Pattern.compile("[.]jpg|png|jpeg|gif|bmp|ico$");
			// Matcher matcher = reg.matcher(fileName);
			// if (!matcher.find() || fileName.toLowerCase().indexOf("jsp") !=
			// -1) {
			// state = "文件类型不允许！";
			// break;
			// }
			// // 将流转出byte数组, 上传数据要用到
			// byte[] data = IOUtils.toByteArray(fis.openStream());
			// // 文件的一些信息, 上传数据要用到
			// Map<String, String> info = new HashMap<String, String>();
			// info.put("ent_id", env.getgCustId()); // 上传的商户id
			// info.put("type", fileName.substring(fileName.lastIndexOf("."),
			// fileName.length())); // 文件类型
			// if (info.get("type").length() > 9) {
			// info.put("type", info.get("type").substring(0, 9));
			// }
			// info.put("size", data.length + ""); // 尺寸
			// info.put("ref_info", params.get("ref_info")); // 关联数据的id
			// info.put("path", "img/" + info.get("ent_id") + "/" + new
			// Date().getTime() + info.get("type")); // 路径+文件名
			// // 上传数据
			// params.put("url", ImageUpUtils.upload(data, info));
			// if (Tools.isEmpty(params.get("url"))) {
			// state = "上传图片失败";
			// }
			// }
			// in.close();
			// }
			// if (Tools.isEmpty(params.get("pictitle"))) {
			// params.put("pictitle", params.get("fileName"));
			// }
			// String str="{'original':'" + params.get("fileName") + "','url':'"
			// + params.get("url")+
			// "','title':'" + params.get("pictitle") + "','state':'" + state +
			// "'}";
			// System.out.println("str:"+str);
			// params.put("pictitle", params.get("pictitle").replace("&",
			// "&amp;").replace("'", "&qpos;")
			// .replace("\"", "&quot;").replace("<", "&lt;").replace(">",
			// "&gt;"));
			// response.getWriter().print("{'original':'" +
			// params.get("fileName") + "','url':'" + params.get("url")
			// + "','title':'" + params.get("pictitle") + "','state':'" + state
			// + "'}");
			// result.put("original",params.get("fileName"));
			// result.put("url",params.get("url"));
			// result.put("title",params.get("pictitle"));
			// result.put("state",state);
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		  request.setCharacterEncoding("utf-8");//防止中文名乱码
//	        int sizeThreshold=1024*6; //缓存区大小
//	        String basePath = "/upload/";
//	        File repository = new File(basePath); //缓存区目录
//	        long sizeMax = 1024 * 1024 * 2;//设置文件的大小为2M
//	        final String allowExtNames = "png,jpg,gif,bmp,rar,rar,txt,docx";
//	        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//	        diskFileItemFactory.setRepository(repository);
//	        diskFileItemFactory.setSizeThreshold(sizeThreshold);
//	        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
//	        servletFileUpload.setSizeMax(sizeMax);
//	        List<FileItem> fileItems = null;
//	        try{
//	            fileItems = servletFileUpload.parseRequest(request);
//	            for(FileItem fileItem:fileItems){
//	            	
//	                long size=0;
//	                String filePath = fileItem.getName();
//	                System.out.println("fileItems"+filePath);
//	                if(filePath==null || filePath.trim().length()==0)
//	                    continue;
//	                String fileName=filePath.substring(filePath.lastIndexOf(File.separator)+1);
////	                String fileName=String.valueOf(System.currentTimeMillis());
//	                String extName=filePath.substring(filePath.lastIndexOf(".")+1);
////	                fileName+="."+extName;
//	                if(allowExtNames.indexOf(extName)!=-1)
//	                {
//	                    try {
//	                        fileItem.write(new File(basePath+File.separator+fileName));
//	                    } catch (Exception e) {
//	                        e.printStackTrace();
//	                    }
//	                }
//	                else{
//	                    throw new FileUploadException("file type is not allowed");
//	                }
//	            }
//	        }catch(FileSizeLimitExceededException e){
//	            System.out.println("file size is not allowed");
//	        }catch(FileUploadException e1){
//	            e1.printStackTrace();
//	        }
		
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断是否是表单文件类型
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload sfu = new ServletFileUpload(factory);
//		List items = sfu.parseRequest(request);//从request得到所有上传域的列表
//		for(Iterator iter = items.iterator();iter.hasNext();){
//		    FileItem fileitem =(FileItem) iter.next();
//		    if(!fileitem.isFormField()&&fileitem!=null){//判读不是普通表单域即是file
//		        System.out.println("name:"+fileitem.getName());
//		    }
//		}    
		System.out.println("...................");
		DiskFileItemFactory factory = new DiskFileItemFactory();   
        ServletFileUpload upload = new ServletFileUpload(factory);   
        upload.setHeaderEncoding("UTF-8");  
        List items = upload.parseRequest(request);  
        Map param = new HashMap();   
        for(Object object:items){  
            FileItem fileItem = (FileItem) object;   
            System.out.println("name:"+fileItem.getName());
            result.put("name:", fileItem.getName());
            if (fileItem.isFormField()) {   
                param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));//如果你页面编码是utf-8的   
            }  
        }  
		return "test2";
	}
	
	 // 访问路径为：http://127.0.0.1:8080/file  
    @RequestMapping("/file")  
    public String file() {  
        return "/file";  
    }  
    
    /**  
     * 文件上传具体实现方法;  
     *   
     * @param file  
     * @return  
     */  
    @RequestMapping("/upload")  
    @ResponseBody  
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {  
        if (!file.isEmpty()) {  
            try {  
                /*  
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到  
                 * d:/files大家是否能实现呢？ 等等;  
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；  
                 * 3、文件格式; 4、文件大小的限制;  
                 */  
                BufferedOutputStream out = new BufferedOutputStream(  
                        new FileOutputStream(new File(  
                                file.getOriginalFilename())));  
                System.out.println(file.getName());
                out.write(file.getBytes());  
                out.flush();  
                out.close();  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
                return "上传失败," + e.getMessage();  
            } catch (IOException e) {  
                e.printStackTrace();  
                return "上传失败," + e.getMessage();  
            }  
  
            return "上传成功";  
  
        } else {  
            return "上传失败，因为文件是空的.";  
        }  
    }  
      
    // 访问路径为：http://127.0.0.1:8080/file  
        @RequestMapping("/mutifile")  
        public String mutifile() {  
            return "/test3";  
        }  
        
        /**  
         * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile  
         *   
         * @param request  
         * @return  
         */  
      
        @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)  
        @ResponseBody  
        public String handleFileUpload(HttpServletRequest request) {  
        	MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
            List<MultipartFile> files = ((MultipartHttpServletRequest) request)  
                    .getFiles("file"); 
            String name=params.getParameter("name");
            System.out.println("name:"+name);
            
            String id=params.getParameter("id");
            System.out.println("id:"+id);
            MultipartFile file = null;  
            BufferedOutputStream stream = null;  
            for (int i = 0; i < files.size(); ++i) {  
                file = files.get(i);  
                if (!file.isEmpty()) {  
                    try {  
                        byte[] bytes = file.getBytes();  
                        stream = new BufferedOutputStream(new FileOutputStream(  
                                new File("d:/"+file.getOriginalFilename())));  
                        stream.write(bytes);  
                        stream.close();  
                    } catch (Exception e) {  
                        stream = null;  
                        return "You failed to upload " + i + " => "  
                                + e.getMessage();  
      
                    }  
                } else {  
                    return "You failed to upload " + i  
                            + " because the file was empty.";  
                }  
      
            }  
            return "upload successful";  
      
        }  
}
