package sql;


import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.TableStyle;

public class POITLStyle {
    public static Style getHeaderStyle(){
        Style style = new Style();
        style.setBold(true);
        style.setFontSize(14);
        style.setColor("000000");
        style.setFontFamily("微软雅黑");
        return style;
    }

    public static TableStyle getHeaderTableStyle(){
        TableStyle style = new TableStyle();;
        style.setBackgroundColor("FFFFFF");
        return style;
    }

    public static Style getBodyStyle(){
        Style style = new Style();
        style.setBold(false);
        style.setFontSize(12);
        style.setColor("000000");
        style.setFontFamily("微软雅黑");
        return style;
    }

    public static TableStyle getBodyTableStyle(){
        TableStyle style = new TableStyle();;
        style.setBackgroundColor("FFFFFF");
        return style;
    }
}
