package com.tay.tools;
import com.tay.entity.FileEntity;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HadoopTool {
    public  String url="hdfs://hadoop01:9000";
    Configuration con=null;
    FileSystem fileSystem=null;
/*    public HadoopTool() {
        try {

        }catch (Exception e){
            e.printStackTrace();
        }

    }*/

    /**
     * 获取文件列表
     */
    public List<FileEntity> getList(String pathForNow,String users) {
        List<FileEntity> list= new ArrayList<>();
        try{
            con=new Configuration();
            con.set("dfs.replication","1");
            con.set("dfs.client.use.datanode.hostname","true");
            fileSystem=FileSystem.get(new URI(url),con,users);
            FileStatus[] fileStatuses=fileSystem.listStatus(new Path(pathForNow));
            int id=1;
            for(FileStatus file:fileStatuses){
                FileEntity fileEntity= new FileEntity();
                if(file.getOwner().equals(users)){
                fileEntity.setLen(file.getLen());
                fileEntity.setPath(file.getPath().toString());
                fileEntity.setTime(new Date(file.getAccessTime()).toString());
                fileEntity.setId(id);
                id++;
                list.add(fileEntity);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return list;
        }
    }

    /**
     * 上传文件
     * @throws Exception
     */
    @Test
    public void upload(String file_path,String pathForNow,String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        Path originPath = new Path(file_path);
        Path targetPath = new Path(pathForNow);
        fileSystem.copyFromLocalFile(originPath, targetPath);
    }


    /**
     * 获取到所有的文件列表
     *
     * @throws Exception
     */
    @Test
    public void allList(String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        RemoteIterator<LocatedFileStatus> re = fileSystem.listFiles(new Path("/"), true);
        while (re.hasNext()) {
            LocatedFileStatus locatedFileStatus = re.next();
            System.out.println(locatedFileStatus.getPath());
        }
    }
    /**
     * 创建hadoop文件
     */


    public void mkdir(String dir_name,String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        fileSystem.mkdirs(new Path(dir_name));


    }

    /**
     * 读取hadoop文件
     *
     * @throws Exception
     */

    public String open(String open_file_path,String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        FSDataInputStream in  = fileSystem.open(new Path(open_file_path));
        String msg=in.readUTF();

        IOUtils.copyBytes(in, System.out, 1024);
        return msg;
    }



    /**
     * 删除
     *
     * @throws Exception
     */

    public void del(String del_path,String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        boolean result = fileSystem.delete(new Path(del_path),true);

    }

    /**
     * 从hadoop服务器上下载文件到本地
     *
     * @throws Exception
     */
    @Test
    public void download(String path,String users) throws Exception {
        con=new Configuration();
        con.set("dfs.replication","1");
        con.set("dfs.client.use.datanode.hostname","true");
        fileSystem=FileSystem.get(new URI(url),con,users);
        Path originPath = new Path(path);
        Path targetPath = new Path("d:/file/download/");
        fileSystem.copyToLocalFile(false, originPath, targetPath, true);
    }

    }




