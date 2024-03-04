package tms.backend.controledeacesso.data.models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private Class<?> requiredResource;

    private Object resourceId;

    private static final long serialVersionUID = 1L;
}
