package tech.anteeone.beatsell.repositories.api;

import tech.anteeone.beatsell.utils.exceptions.ApiException;

public interface ApiRepository {

    String get() throws ApiException;

}
