/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mongodb.client.model.bulk;

import com.mongodb.annotations.Sealed;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.Filters;
import com.mongodb.internal.client.model.bulk.ConcreteClientUpdateManyOptions;
import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/**
 * The options to apply when updating documents.
 *
 * @since 5.3
 */
@Sealed
public interface ClientUpdateManyOptions extends BaseClientUpdateOptions {
    /**
     * Creates the default options.
     *
     * @return The default options.
     */
    static ClientUpdateManyOptions clientUpdateManyOptions() {
        return new ConcreteClientUpdateManyOptions();
    }

    /**
     * Sets the filters specifying to which array elements an update should apply.
     *
     * @param arrayFilters The array filters. {@code null} represents the server default.
     * @return {@code this}.
     * @see Filters
     */
    @Override
    ClientUpdateManyOptions arrayFilters(@Nullable Iterable<? extends Bson> arrayFilters);

    /**
     * Sets the collation.
     *
     * @param collation The collation. {@code null} represents the server default.
     * @return {@code this}.
     */
    @Override
    ClientUpdateManyOptions collation(@Nullable Collation collation);

    /**
     * Sets the index specification,
     * {@code null}-ifies {@linkplain #hintString(String) hint string}.
     *
     * @param hint The index specification. {@code null} represents the server default.
     * @return {@code this}.
     */
    @Override
    ClientUpdateManyOptions hint(@Nullable Bson hint);

    /**
     * Sets the index name,
     * {@code null}-ifies {@linkplain #hint(Bson) hint}.
     *
     * @param hintString The index name. {@code null} represents the server default.
     * @return {@code this}.
     */
    @Override
    ClientUpdateManyOptions hintString(@Nullable String hintString);

    /**
     * Enables or disables creation of a document if no documents match the filter.
     *
     * @param upsert The upsert flag. {@code null} represents the server default.
     * @return {@code this}.
     */
    @Override
    ClientUpdateManyOptions upsert(@Nullable Boolean upsert);
}
