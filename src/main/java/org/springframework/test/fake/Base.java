package org.springframework.test.fake;

public interface Base<ID> {
    ID getId();
    void setId(ID id);
}
