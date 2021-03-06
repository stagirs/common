/*
 * Copyright 2016 Dmitriy Malakhov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.stagirs.common.model;

import java.util.List;

/**
 *
 * @author Dmitriy Malakhov
 */
public class DocumentUtils {
    public static void fillSentences(Document document, List<Sentence> sentences){
        for (Block block : document.getBlocks()) {
            if(block instanceof Section){
                fillSentences((Section) block, sentences);
            }
            if(block instanceof Point){
                fillSentences((Point) block, sentences);
            }
        }
    }
    
    public static void fillSentences(Section section, List<Sentence> sentences){
        for (Block block : section.getBlocks()) {
            if(block instanceof Section){
                fillSentences((Section) block, sentences);
            }
            if(block instanceof Point){
                fillSentences((Point) block, sentences);
            }
        }
    }
    
    public static void fillSentences(Point point, List<Sentence> sentences){
        sentences.addAll(point.getSentences());
    }
}
