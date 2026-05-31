package com.kukos.yunpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kukos.yunpicturebackend.model.dto.file.UploadPictureResult;
import com.kukos.yunpicturebackend.model.dto.picture.PictureQueryRequest;
import com.kukos.yunpicturebackend.model.dto.picture.PictureReviewRequest;
import com.kukos.yunpicturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.kukos.yunpicturebackend.model.dto.picture.PictureUploadRequest;
import com.kukos.yunpicturebackend.model.entity.Picture;
import com.kukos.yunpicturebackend.model.entity.User;
import com.kukos.yunpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * @author kukos
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2025-12-09 13:56:05
 */
public interface PictureService extends IService<Picture> {


    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    /**
     * 将查询请求对象转换为mybatisPlus 适配的对象
     *
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 向返回给浏览器的pictureVO封装上修改人的信息
     *
     * @param picture
     * @param request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页获取图片封装
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 对修改图片进行参数校验
     *
     * @param picture
     */
    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 为图片修改设置审核参数
     *
     * @param picture
     * @param loginUser
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取图片和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 返回抓取成功的数量
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

    /**
     * 删除旧图片
     * @param oldpicture
	12345678911
     */
    public void clearPictureFile(Picture oldpicture);
}
