package com.tech.jvm;

/**
 * @author xxx_xx
 * @date 2018/6/24
 * 定位占用CPU最多的线程
 * 在linux下执行代
 * jps 得到进程ip
 * 根据进程ip 执行命令top -Hp 进程号找到占用cpu最高的线程号
 * 根据命令jstack 进程号得到栈信息，根据线程号转成16进制在栈信息中找到线程名
 */
public class CpuCostThread {
    public static void main(String args[]){
        for(int i=0;i<10;i++){
            new Thread(){
                public void run(){
                    try{
                        Thread.sleep(10000);
                    }catch(Exception e){}
                }
            }.start();
        }
        Thread t=new Thread(){
            public void run(){
                int i=0;
                while(true){
                    i=(i++)/100;
                }
            }
        };
        t.setName("Busiest Thread");
        t.start();
    }
}
