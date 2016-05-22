package com.tokopedia.producttokopedia.db.table;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by Tokopedia01 on 5/22/2016.
 */
@Table(name = "ProductSearch")
public class ProductSearchTbl extends Model {
    @Column(name = "keyword", index = true)
    public String keyword;

    @Column(name = "result")
    public String resutl;

    public ProductSearchTbl(){
        super();
    }

    public ProductSearchTbl(String keyword, String resutl) {
        super();
        this.keyword = keyword;
        this.resutl = resutl;
    }
    public static ProductSearchTbl getResult(String keyword){
        return new Select()
                .from(ProductSearchTbl.class)
                .where("keyword = ?", keyword)
                .executeSingle();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getResutl() {
        return resutl;
    }

    public void setResutl(String resutl) {
        this.resutl = resutl;
    }
}
