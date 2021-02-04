
package com.jdbc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdbc.model.AjaxResult;
import com.jdbc.model.Page;
import com.jdbc.model.VendorModel;
import com.jdbc.service.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController extends BaseApiController {

    @Resource
    private VendorService vendorService;

    @RequestMapping("/list")
    public String getlist(Page page, VendorModel vendorModel, Map<String, Object> map) {
        List<VendorModel> vendorList = vendorService.queryPageVendor(page, vendorModel, null);
        map.put("vendorList", vendorList);
        map.put("page", page);
        map.put("menuclass", "vendor");
        
        map.put("vendorModel", vendorModel);
        return "Vendor";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult getVendorModel(Long id) {
        if (id == null) {
            return error();
        }
        VendorModel vendor = vendorService.queryVendorById(id);
        return success(vendor);
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = vendorService.removeVendorById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody VendorModel vendor) {
        if (vendor == null) {
            return error();
        }
        int res = 0;
        if (vendor.getId() == null || vendor.getId() == 0) {
            res = vendorService.save(vendor);
        } else {
            res = vendorService.edit(vendor);
        }
        return res > 0 ? success() : error();
    }
}

            