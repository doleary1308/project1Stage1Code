import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Invoice implements Serializable {
  private static final long serialVersionUID = 1L;
  private String type;
  private String name;
  private Calendar date;
  public Invoice(String type, String title) {
    this.type = type;
    this.name = title;
    date = new GregorianCalendar();
    date.setTimeInMillis(System.currentTimeMillis());
  }
  public boolean onDate(Calendar date) {
    return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR)) &&
            (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH)) &&
            (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
  }
  public String getType() {
    return type;
  }
  public String getName() {
    return name;
  }
  public String getDate() {
    return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
  }
  public String toString(){
    return (type + "   " + name);
  }
}