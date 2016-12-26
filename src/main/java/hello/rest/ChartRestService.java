package hello.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartRestService {

    @RequestMapping(value = "/rest/pie-data", method = RequestMethod.GET)
    public List<Object> getPieData() {
        List<Object> pieData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Object> dataElement = new ArrayList<>();
            dataElement.add("Region_" + i);
            dataElement.add(Math.random() * 10);
            pieData.add(dataElement);
        }
        return pieData;
    }

    @RequestMapping(value = "/rest/column-data", method = RequestMethod.GET)
    public List<Map<String, Object>> getColumnData() {
        List<Map<String, Object>> columnData = new ArrayList<>();
        Map<String, Object> headerElement = new HashMap<>();
        headerElement.put("name", "Month");
        headerElement.put("data", new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        columnData.add(headerElement);

        Map<String, Object> dataElement1 = new HashMap<>();
        dataElement1.put("name", "WordPress");
        dataElement1.put("data", new Integer[]{4, 5, 6, 2, 5, 7, 2, 1, 6, 7, 3, 4});
        columnData.add(dataElement1);

        Map<String, Object> dataElement2 = new HashMap<>();
        dataElement2.put("name", "Highcharts");
        dataElement2.put("data", new Integer[]{7, 8, 9, 6, 7, 10, 9, 7, 6, 9, 8, 4});
        columnData.add(dataElement2);

        Map<String, Object> dataElement3 = new HashMap<>();
        dataElement3.put("name", "CodeIgniter");
        dataElement3.put("data", new Integer[]{5, 2, 3, 6, 7, 1, 2, 6, 6, 4, 6, 3});
        columnData.add(dataElement3);

        return columnData;
    }
}
