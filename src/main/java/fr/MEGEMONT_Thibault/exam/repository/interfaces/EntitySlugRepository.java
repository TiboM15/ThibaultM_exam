package fr.MEGEMONT_Thibault.exam.repository.interfaces;

import java.util.Optional;

public interface EntitySlugRepository<T> {
        Optional<T> findBySlug(String name);
}
