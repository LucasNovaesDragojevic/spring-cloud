package com.purchase.service;

import java.util.Set;
import java.util.stream.Collectors;

import com.purchase.client.ProviderClient;
import com.purchase.dto.ProviderDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProviderService
{
    private static final String NO_PROVIDER_FOUND_WITH_REGION = "No provider found with region: ";

    private static final String NO_PROVIDER_FOUND_TO_CHOSE_THE_BEST = "No provider found to chose the best.";

    private static final Logger LOG = LoggerFactory.getLogger(ProviderService.class);

    @Autowired
    private ProviderClient providerClient;

    @CircuitBreaker(name = "findByRegion", fallbackMethod = "findProviderByRegionFallback")
    public Set<ProviderDto> findByRegion(String region) 
    {
        var collectionModel = providerClient.findByRegion(region);

        if (collectionModel.getContent().isEmpty())
        {
            LOG.error(NO_PROVIDER_FOUND_WITH_REGION + region);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, NO_PROVIDER_FOUND_WITH_REGION + region);
        }
        
        return collectionModel.getContent().stream().collect(Collectors.toSet());
    }

    public ProviderDto chooseTheBest(Set<ProviderDto> providers) 
    {
        return providers.stream()
                        .findAny()
                        .orElseThrow(() -> {
                            LOG.error(NO_PROVIDER_FOUND_TO_CHOSE_THE_BEST);
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, NO_PROVIDER_FOUND_TO_CHOSE_THE_BEST);
                        });
    }

    private Set<ProviderDto> findProviderByRegionFallback(String region, Exception exception)
    {
        LOG.error(exception.getLocalizedMessage());
        return Set.of(new ProviderDto("00000000-0000-0000-0000-000000000000"));
    }
}
