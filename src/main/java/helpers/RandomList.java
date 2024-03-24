package helpers;

import org.openqa.selenium.WebElement;

import java.util.*;

public class RandomList {
    public static Set<WebElement> arr(List<WebElement> webElement){
        Set<WebElement> result = new HashSet<>();
        for (WebElement webElement1 : webElement){
            if (webElement.indexOf(webElement1)%2 == 0){
                result.add(webElement1);
            }
        }
        return  result;
    }
}
