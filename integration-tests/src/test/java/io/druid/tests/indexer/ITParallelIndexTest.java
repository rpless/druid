/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.tests.indexer;

import io.druid.testing.guice.DruidTestModuleFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(moduleFactory = DruidTestModuleFactory.class)
public class ITParallelIndexTest extends AbstractITBatchIndexTest
{
  private static String INDEX_TASK = "/indexer/wikipedia_parallel_index_task.json";
  private static String INDEX_QUERIES_RESOURCE = "/indexer/wikipedia_parallel_index_queries.json";
  private static String INDEX_DATASOURCE = "wikipedia_parallel_index_test";

  @Test
  public void testIndexData() throws Exception
  {
    try {
      doIndexTestTest(
          INDEX_DATASOURCE,
          INDEX_TASK,
          INDEX_QUERIES_RESOURCE
      );
    }
    finally {
      unloadAndKillData(INDEX_DATASOURCE);
    }
  }
}
