package fr.sncf.ecommerce.common.exceptions;

public class ResourceNotFoundExeption extends RuntimeException {
    public ResourceNotFoundExeption(Class<?> clz) {
        super(String.format("ressource of type %s was not found", clz.getSimpleName()));
    }
}
