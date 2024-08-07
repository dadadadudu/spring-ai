/*
 * Copyright 2023 - 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.ai.embedding;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.metadata.EmptyUsage;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.model.ResponseMetadata;

/**
 * Common AI provider metadata returned in an embedding response.
 *
 * @author Christian Tzolov
 * @author Thomas Vitale
 */
public class EmbeddingResponseMetadata extends HashMap<String, Object> implements ResponseMetadata {

	@Serial
	private static final long serialVersionUID = 1L;

	private String model;

	private Usage usage;

	public EmbeddingResponseMetadata() {
	}

	public EmbeddingResponseMetadata(String model, Usage usage) {
		this.model = model;
		this.usage = usage;
	}

	public EmbeddingResponseMetadata(Map<String, ?> metadata) {
		super(metadata);
	}

	/**
	 * The model that handled the request.
	 */
	public String getModel() {
		return this.model != null ? this.model : "";
	}

	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * The AI provider specific metadata on API usage.
	 * @see Usage
	 */
	public Usage getUsage() {
		return this.usage != null ? this.usage : new EmptyUsage();
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}

}
