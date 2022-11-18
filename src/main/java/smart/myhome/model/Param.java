package smart.myhome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "param")
public class Param  implements Serializable  {
    private static final long serialVersionUID = -1826984753959217875L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_param")
    private String nameParam;

    @Column(name = "legend")
    private String legend;

    @Column(name = "units")
    private String units;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameParam() {
        return nameParam;
    }

    public void setNameParam(String nameParam) {
        this.nameParam = nameParam;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
