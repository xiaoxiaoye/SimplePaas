package com.remmy.simplepaas.controller;

import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.service.ApplicationSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yejiaxin
 */
@Api(tags = "应用搜索", description = "应用搜索")
@RestController
public class ApplicationSearchController {
    private final ApplicationSearchService searchService;

    public ApplicationSearchController(ApplicationSearchService searchService) {
        this.searchService = searchService;
    }

    @ApiOperation(value = "应用搜索", notes = "应用搜索")
    @GetMapping("/application/search")
    public RespBean search(String keyword) {
        RespBean res = searchService.search(keyword);
        return RespBean.ok("success", res);
    }
}
