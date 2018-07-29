package pro.xway.springbatch.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Item {
    private String ssoid;
    private long date;
    private String grp;
    private String type;
    private String subtype;
    private String url;
    private String orgid;
    private String formid;
    private String code;
    private String ltpa;
    private String sudirresponse;
    private String ymdh;

    @Id
    @GeneratedValue
    private long id;
    
    public Item(String ssoid, long date, String grp, String type, String subtype, String url,
                String orgid, String formid, String code, String ltpa, String sudirresponse,
                String ymdh) {
        this.ssoid = ssoid;
        this.date = date;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgid = orgid;
        this.formid = formid;
        this.code = code;
        this.ltpa = ltpa;
        this.sudirresponse = sudirresponse;
        this.ymdh = ymdh;
    }

    public Item() {
    }


    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public String getYmdh() {
        return ymdh;
    }

    public void setYmdh(String ymdh) {
        this.ymdh = ymdh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return date == item.date &&
                id == item.id &&
                Objects.equals(ssoid, item.ssoid) &&
                Objects.equals(grp, item.grp) &&
                Objects.equals(type, item.type) &&
                Objects.equals(subtype, item.subtype) &&
                Objects.equals(url, item.url) &&
                Objects.equals(orgid, item.orgid) &&
                Objects.equals(formid, item.formid) &&
                Objects.equals(code, item.code) &&
                Objects.equals(ltpa, item.ltpa) &&
                Objects.equals(sudirresponse, item.sudirresponse) &&
                Objects.equals(ymdh, item.ymdh);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ssoid, date, grp, type, subtype, url, orgid, formid, code, ltpa, sudirresponse, ymdh, id);
    }
}
