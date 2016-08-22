package com.zjffdu.tutorial.python;

import java.io.*;

/**
 * Created by jzhang on 8/4/16.
 */
public class PythonRepl {

  public static void main(String[] args) throws IOException, InterruptedException {
    ProcessBuilder procBuilder = new ProcessBuilder("python", "-iu");
    procBuilder.redirectErrorStream(true);
    Process process = procBuilder.start();
    InputStream in = process.getInputStream();
    OutputStream out = process.getOutputStream();
    new ReaderThread(in).start();
//    PrintWriter writer = new PrintWriter(out, true);
//    writer.println("\"abd\"");
//    writer.println("exit()");

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
    writer.write("1+1\n");
    writer.write("\"*!?flush reader!?*\"\n");
    writer.write("exit()\n");
    writer.flush();
    int ret = process.waitFor();
    System.out.println("ret:" + ret);
  }

  static class ReaderThread extends Thread {

    private BufferedReader reader;

    public ReaderThread(InputStream in) {
      this.reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public void run() {
      String line = null;
      try {
        while((line=reader.readLine())!=null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
