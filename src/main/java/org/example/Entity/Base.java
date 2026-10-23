package org.example.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Base {
    private static long ultimoId = 0;
    @Getter
    @EqualsAndHashCode.Include
    private final Long id = ++ultimoId;
    @Getter @Setter
    private boolean eliminado;
    @Getter @Setter
    private LocalDateTime createdAt;
}
