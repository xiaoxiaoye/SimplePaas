package com.remmy.simplepaas.controller;


import com.remmy.simplepaas.client.registry.RegistryClient;
import com.remmy.simplepaas.client.registry.RegistryClientFactory;
import com.remmy.simplepaas.dto.Image;
import com.remmy.simplepaas.dto.RepositoryStatus;
import com.remmy.simplepaas.dto.RepositoryType;
import com.remmy.simplepaas.common.RespBean;
import com.remmy.simplepaas.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yejiaxin
 */
@Api(tags = "镜像管理", description = "镜像管理")
@RestController
public class RepositoriesController {
    private final RegistryClient client;
    private final ImageService imageService;

    public RepositoriesController(RegistryClientFactory clientFactory, ImageService imageService) {
        this.client = clientFactory.getClient(RepositoryType.V2);
        this.imageService = imageService;
    }

    @ApiOperation(value = "获取镜像列表", notes = "镜像列表")
    @GetMapping("/repository/images")
    public RespBean listImages() throws Exception{
        List<Image> imageList = imageService.listImagesByRepositoryName();
        return RespBean.ok("success", imageList);
    }

    @ApiOperation(value = "仓库详情", notes = "获取仓库详情")
    @GetMapping("/repository/info")
    public RespBean getInfo() throws Exception{
        RepositoryStatus repository = client.getInfo();
        return RespBean.ok("success", repository);
    }
}
