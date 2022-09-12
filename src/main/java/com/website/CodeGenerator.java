package com.website;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        // 1. 设置数据库相关内容
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/bilibiliwebsite?serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDbType(DbType.MYSQL); // 设置数据库类型
        autoGenerator.setDataSource(dataSourceConfig);

        // 2. 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("D:\\Java\\JavaProject\\AcfunWebsite\\src\\main\\java"); // 生成的文件输出到哪个位置
        globalConfig.setOpen(false); // 设置生成完毕后是否打开生产代码所在的目录， 默认为True
        globalConfig.setAuthor("邓斯元"); // 设置作者
        globalConfig.setFileOverride(true); // 设置是否覆盖原始文件，若为True且有重名文件则覆盖
        globalConfig.setMapperName("%sDao"); // 设置数据层接口名，%s为占位符，指代模块的名称即表名
        globalConfig.setIdType(IdType.AUTO); // 设置id生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        // 3. 设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.website.acfunwebsite"); // 设置父包名
        packageConfig.setEntity("domain");  // 设置实体类包名
        packageConfig.setMapper("Dao");  // 设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);

        // 4. 策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("tbl_video", "tbl_play"); // 设置当前参与生成的表名，既有多少张表要参与对应模块的生成，若写错或没有则不会生成
        strategyConfig.setTablePrefix("tbl_"); // 设置数据表名的前缀，模块名=数据库表面-前缀名 如User = tbl_user - tbl_
        strategyConfig.setRestControllerStyle(true); // 设置Controller模块的Rest风格
        strategyConfig.setVersionFieldName("version"); // 设置乐观锁对应字段
        strategyConfig.setLogicDeleteFieldName("deleted"); // 设置逻辑删除对应字段
        strategyConfig.setEntityLombokModel(true); // 设置lombok
        autoGenerator.setStrategy(strategyConfig);

        // 5. 导入设置
        autoGenerator.execute();
    }
}
