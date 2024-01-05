package models;

import java.util.List;

public class Pet {
    private Integer id;
    private Category category;

    public List<Specifics> getSpecifics() {
        return specifics;
    }

    public void setSpecifics(List<Specifics> specifics) {
        this.specifics = specifics;
    }

    private List<Specifics> specifics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static class Specifics {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}




