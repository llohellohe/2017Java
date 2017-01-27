package com.yangqi.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by yangqi on 24/01/2017.
 */
@WebServlet(urlPatterns = "/demo", asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("servlet start" + new Date() + "."+System.currentTimeMillis());
        out.flush();

        //�����߳���ִ��ҵ����ã������为�������Ӧ�����߳��˳�
        AsyncContext ctx = req.startAsync();
        new Thread(new Executor(ctx)).start();

        out.println("servlet end" + new Date() + "."+System.currentTimeMillis());
        out.flush();
    }
}

class Executor implements Runnable {
    private AsyncContext ctx = null;
    public Executor(AsyncContext ctx){
        this.ctx = ctx;
    }

    public void run(){
        try {
            //�ȴ�ʮ���ӣ���ģ��ҵ�񷽷���ִ��
            Thread.sleep(10000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("business end:" + new Date() + "."+System.currentTimeMillis());
            out.flush();
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
