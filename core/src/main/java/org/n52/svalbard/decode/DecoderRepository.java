/*
 * Copyright 2016-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.svalbard.decode;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.n52.janmayen.lifecycle.Constructable;
import org.n52.svalbard.AbstractCodingRepository;

import com.google.common.annotations.VisibleForTesting;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann
 */
public class DecoderRepository extends AbstractCodingRepository<DecoderKey, Decoder<?, ?>, DecoderFactory>
        implements Constructable {

    @Inject
    private Optional<Collection<Decoder<?, ?>>> decoders;

    @Inject
    private Optional<Collection<DecoderFactory>> decoderFactories;

    @VisibleForTesting
    void setDecoders(Collection<Decoder<?, ?>> decoders) {
        this.decoders = Optional.of(decoders);
    }

    @VisibleForTesting
    void setDecoderFactories(Collection<DecoderFactory> decoderFactories) {
        this.decoderFactories = Optional.of(decoderFactories);
    }

    @Override
    public void init() {
        setProducers(getProviders(decoders.get(), decoderFactories.get()));
    }

    public Set<Decoder<?, ?>> getDecoders() {
        return getComponents();
    }

    public boolean hasDecoder(DecoderKey key, DecoderKey... keys) {
        return hasComponent(key, keys);
    }

    @SuppressWarnings("unchecked")
    public <F, T> Decoder<F, T> getDecoder(DecoderKey key, DecoderKey... keys) {
        return (Decoder<F, T>) getComponent(key, keys);
    }

    @Override
    protected CompositeKey createCompositeKey(List<DecoderKey> keys) {
        return new CompositeDecoderKey(keys);
    }

    private class CompositeDecoderKey extends CompositeKey implements DecoderKey {
        CompositeDecoderKey(Iterable<DecoderKey> keys) {
            super(keys);
        }

        @Override
        public DecoderKey asKey() {
            return this;
        }
    }
}
