package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeviceController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public String deviceDetect(Device device, Model model) {

        String deviceType = "unknown";

        if (device.isNormal()) {
            deviceType = "desktop";
        }
        else if (device.isMobile()) {
            deviceType = "mobile";
        }
        else if (device.isTablet()) {
            deviceType = "tablet";
        }

        logger.info("deviceType: {}", deviceType);

        model.addAttribute("deviceType", deviceType);
        return "device";
    }
}
