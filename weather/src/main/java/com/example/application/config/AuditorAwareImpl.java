package com.example.application.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        // TODO: This is temporary to make the site work. need implementation get current user
          return Optional.of(1l);

    }
}