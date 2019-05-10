import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class MemoryEater
{

public static String humanReadableByteCount(long bytes, boolean si) {
    int unit = si ? 1000 : 1024;
    if (bytes < unit) return bytes + " B";
    int exp = (int) (Math.log(bytes) / Math.log(unit));
    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
}

  public static void main(String[] args)
  {
    Vector v = new Vector();
    long allocated = 0;
    while (true)
    {
      byte b[] = new byte[1048576];
      v.add(b);
      allocated += 1048576;
      Runtime rt = Runtime.getRuntime();
      System.out.println( "allocated: " + humanReadableByteCount(allocated, true) +
                          ", free: " + humanReadableByteCount(rt.freeMemory(), true) +
                          ", total: " + humanReadableByteCount(rt.totalMemory(), true) );
      try {
          TimeUnit.MILLISECONDS.sleep(50);
      } catch (Exception e) {
      }
    }
  }
}

