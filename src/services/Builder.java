package services;

import core.Request;

public interface Builder {
    Builder setValues(String[] values);

    Request build();
}
