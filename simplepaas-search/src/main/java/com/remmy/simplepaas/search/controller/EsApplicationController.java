package com.remmy.simplepaas.search.controller;

import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.search.domain.EsApplication;
import com.remmy.simplepaas.search.service.EsApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yejiaxin
 */
@Api(tags = "ES应用搜索")
@RestController
public class EsApplicationController {
    private final EsApplicationService esApplicationService;

    public EsApplicationController(EsApplicationService esApplicationService) {
        this.esApplicationService = esApplicationService;
    }

    @ApiOperation(value = "导入应用到ES", notes = "导入所有应用到ES")
    @PostMapping("/application/import")
    public RespBean importAll() {
        int count = esApplicationService.importAll();
        return RespBean.ok("import all application to ES, total:" + count);
    }

    @ApiOperation(value = "搜索应用", notes = "搜索应用")
    @GetMapping("/application/search")
    public RespBean search(String keyword) {
        List<EsApplication> applicationList = esApplicationService.search(keyword);
        return RespBean.ok("search success", applicationList);
    }

    @ApiOperation(value = "创建应用", notes = "根据id创建应用")
    @PostMapping("/application/create")
    public RespBean create(Long id) {
        EsApplication app = esApplicationService.create(id);
        return RespBean.ok("create success", app);
    }

    @ApiOperation(value = "删除应用", notes = "根据id删除应用")
    @DeleteMapping("/application/delete")
    public RespBean delete(Long id) {
        esApplicationService.delete(id);
        return RespBean.ok("delete success");
    }
}
