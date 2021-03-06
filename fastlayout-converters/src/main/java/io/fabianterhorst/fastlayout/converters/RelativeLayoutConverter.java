package io.fabianterhorst.fastlayout.converters;

import java.util.ArrayList;
import java.util.List;

import io.fabianterhorst.fastlayout.annotations.Converter;

/**
 * Created by fabianterhorst on 18.05.16.
 */
@Converter("RelativeLayout")
public class RelativeLayoutConverter extends LayoutConverter {

    private List<String> relativeParameters = new ArrayList<String>() {{
        add("android:layout_above");
        add("android:layout_alignBaseline");
        add("android:layout_alignParentBottom");
        add("android:layout_alignEnd");
        add("android:layout_alignBottom");
        add("android:layout_alignLeft");
        add("android:layout_alignRight");
        add("android:layout_alignStart");
        add("android:layout_alignTop");
        add("android:layout_below");
        add("android:layout_centerHorizontal");
        add("android:layout_centerInParent");
        add("android:layout_centerVertical");
        add("android:layout_toEndOf");
        add("android:layout_toLeftOf");
        add("android:layout_toRightOf");
        add("android:layout_toStartOf");
        add("android:layout_alignParentEnd");
        add("android:layout_alignParentLeft");
        add("android:layout_alignParentRight");
        add("android:layout_alignParentStart");
        add("android:layout_alignParentTop");
    }};

    @Override
    public LayoutAttribute onConvertLayoutAttribute(String attributeStartValue, String attributeValue, String attributeName, boolean isString) {
        if(relativeParameters.contains(attributeName)) {
            return new LayoutAttribute(LayoutAttribute.Type.PARAM, "addRule(" + "RelativeLayout." + stringToConstant(attributeToName(attributeName.replace("_to", "_").replace("layout_", ""))).toUpperCase() + (!attributeValue.equals("true") && !attributeValue.equals("false") ? ", " + attributeValue : ", " + "RelativeLayout." + attributeValue.toUpperCase()) + ")");
        }
        return null;
    }
}
