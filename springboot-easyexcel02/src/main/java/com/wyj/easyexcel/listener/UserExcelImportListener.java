package com.wyj.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wyj.easyexcel.entity.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserExcelImportListener extends AnalysisEventListener<User> {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;

    /**
     * 用来临时存储还未到批处理阈值的数据
     */
    private List<User> userList = new ArrayList<>(BATCH_COUNT);

    private Logger logger = LoggerFactory.getLogger(UserExcelImportListener.class);

    /**
     * 每次读取一条时执行
     *
     * @param user
     * @param analysisContext
     */
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        logger.info("解析到一条数据:{}", user);
        userList.add(user);
        if (userList.size() >= BATCH_COUNT) {
            saveData();
            userList.clear();
        }
    }

    /**
     * 全部读取完执行
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        logger.info("所有数据解析完成！");
    }

    private void saveData() {
        logger.info("{}条数据，开始存储数据库！", userList.size());
        logger.info("存储数据库成功！");
    }
}
