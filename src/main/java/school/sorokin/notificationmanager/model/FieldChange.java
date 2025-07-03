package school.sorokin.notificationmanager.model;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FieldChange<T> {
    private T oldField;
    private T newField;
}
