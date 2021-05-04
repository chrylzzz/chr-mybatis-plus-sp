package com.chryl.config.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 需要更改的地方:修改2,3,4,5步
 * 基本配置:GlobalConfig
 * 数据库配置:DataSourceConfig
 * 生成路径配置:PackageConfig
 * <p>
 * Created by Chr.yl on 2021/5/4.
 *
 * @author Chr.yl
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class MPCodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 1.代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        /**
         * 这里不是绝对路径,现在使用绝对路径
         */
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("/Users/chryl/develop/work_Spaces/idea_Project/sp-mp-demo" + "/src/main/java");

        gc.setAuthor("chryl");
        gc.setOpen(false);//是否打开文件夹
        gc.setFileOverride(false);//是否允许覆盖
//        gc.setDateType(DateType.ONLY_DATE);//使用的日期类型
        gc.setIdType(IdType.ID_WORKER);//主键生成策略
        gc.setSwagger2(true);// 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 3.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/chryl?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("chryl");
        mpg.setDataSource(dsc);

        // 4.包配置
        //com.chryl.user
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("user"));//模块名
        pc.setModuleName(scanner("模块名"));//模块名
        pc.setParent("com.chryl");//包名
        pc.setController("controller");
        pc.setEntity("dto");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        /*
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        */
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
//        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /*
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        */

        // 5.策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude("user");//表名
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库字段映射到实体的命名策略
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);//lombok模型
        strategy.setRestControllerStyle(true);//restful api风格
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);//驼峰命名
        strategy.setTablePrefix(pc.getModuleName() + "_");//生成时去掉前缀
        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
