package com.cxmax.mvvmdemo.config.manager;

import android.databinding.tool.util.L;
import android.os.Environment;

import com.cxmax.mvvmdemo.config.BaseController;
import com.cxmax.mvvmdemo.config.Constants;
import com.cxmax.mvvmdemo.utils.FileUtil;

import java.io.File;

/**
 * @Author CaiXi on  2016/8/26 00:48.
 * @Github: https://github.com/cxMax
 * @Description 项目缓存管理类
 */
public class CacheManager {

    private static final String TAG = CacheManager.class.getCanonicalName();

    //*************有SD卡时路径******************//

    public static final String SD_DIR = Environment.getExternalStorageDirectory().getPath();    // SD卡路径

    public static final String SD_APP_DIR = SD_DIR + "/." + Constants.APP_NAME;  // 项目路径

    public static final String SD_LOG_DIR = SD_APP_DIR + "/.log"; // Log保存目录

    public static final String SD_SAVE_DIR = SD_APP_DIR + "/save"; // 文件保存路径

    public static final String SD_CRASH_DIR = SD_APP_DIR + "/.crash"; // 异常日志路径

    public static final String SD_CACHE_DIR = SD_APP_DIR + "/.cache"; // 缓存路径

    public static final String SD_IMAGE_DIR = SD_APP_DIR + "/.image"; // 图片路径

    public static final String SD_AUDIO_DIR = SD_APP_DIR + "/.audio"; // 音频路径

    public static final String SD_VIDEO_DIR = SD_APP_DIR + "/video"; // 视频路径

    private BaseController mController;

    public CacheManager(BaseController controller){
        this.mController = controller;
        init();
    }

    public void init() {
        // 删除以前的残留文件夹
        FileUtil.deleteDirectory(SD_DIR + "/.ugou");
        FileUtil.deleteDirectory(SD_DIR + "/.ugou_");

        createProjectDir();
    }

    private void createProjectDir() {

        L.d( "createProjectDir:" + FileUtil.hasSDCard());

        if (FileUtil.hasSDCard()) {

            File rootDir = new File(SD_APP_DIR);
            File logDir = new File(SD_LOG_DIR);
            File saveDir = new File(SD_SAVE_DIR);
            File crashDir = new File(SD_CRASH_DIR);
            File cacheDir = new File(SD_CACHE_DIR);
            File imageDir = new File(SD_IMAGE_DIR);
            File audioDir = new File(SD_AUDIO_DIR);
            File videoDir = new File(SD_VIDEO_DIR);

            FileUtil.mkdirs(rootDir);
            FileUtil.mkdirs(logDir);
            FileUtil.mkdirs(saveDir);
            FileUtil.mkdirs(crashDir);
            FileUtil.mkdirs(cacheDir);
            FileUtil.mkdirs(imageDir);
            FileUtil.mkdirs(audioDir);
            FileUtil.mkdirs(videoDir);

        } else {
            // do something 后续添加
            L.d("createProjectDir:手机无SD卡");
        }
    }
}
