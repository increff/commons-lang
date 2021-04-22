# commons-lang
commons-lang provides a host of helper utilities for dealing with Collections, DateTime formats and Files among other things

## Overview
The standard Java libraries fail to provide enough methods for manipulation of its core classes. <code>commons-lang</code> provides some of these extra methods. Primarily, <code>commons-lang</code> provides a host of helper utilities for dealing with Collections, Date-Time formats and Files among other things

## Table of Contents
- [commons-lang](#commons-lang)
    * [Overview](#overview)
    * [Installation](#installation)
    * [Key Classes](#key-classes)
        + [CollectionUtil](#collectionutil)
        + [DateUtil](#dateutil)
        + [CryptoUtil](#cryptoutil)
        + [CmdUtil](#cmdutil)
        + [EvalEngine](#evalengine)
        + [FileUtil](#fileutil)
    * [FileFormatUtil](#fileformatutil)
    * [Interner](#interner)
    * [TimerUtil](#timerutil)
    * [License](#license)
## Installation
To add a dependency on this library using Maven, use the following:
```xml
<dependency>
    <groupId>com.increff.commons</groupId>
    <artifactId>increff-commons-lang</artifactId>
    <version>1.4</version>
    <scope>test</scope>
</dependency>
```

## Key Classes
### CollectionUtil
<code>CollectionUtil</code> is a Utility class for conversion of Collections to maps, lists, etc. The primary methods available in the class are
* <code>HashMap<K, T> *toMap*(Collection<T> collection, Function<T, K> mapper)</code>  Allows conversion of a Collection of arbitrary objects into a HashMap such that the objects are stored as the values of the HashMap. The keys corresponding to an object are determined by applying a <code>*mapper*</code> function to the object itself. In this way, we can create a HashMap of Objects where they keys are a specific field of the object and the value is the object itself e.g. a HashMap from ''person_name(String)'' to ''Person(Object)''
* <code>Collection<V> *toList*(Collection<O> list, Function<O, V> mapper)</code>  Collects values from given list of objects, based on given mapper, into a Collection object e.g. <code>toList</code> can be used to generate a list of ''person_name'' fields from a list of ''Person'' objects
* <code>Collection<V> *merge*(Collection<O> list, Function<O, Collection<V>> mapper)</code>  Similar to the <code>toList</code> method, however, <code>merge</code> is used for constructing a continuous list of field from Objects, when the field to be collected itself is a Collection. It returns all the collected lists as a single, merged and continuous lists (''not a list of collected lists'')
* <code>Collection<O> *merge*(Collection<O> list1, Collection<O> list2)</code>:   Merges two collection of objects into one Collection
* <code>List<O> *merge*(List<List<O>> listOfLists)</code>  Merge a list of lists into a single list
* <code>Collection<O> *getDuplicates*(Collection<O> list, Comparator<O> comparator)</code>  Find duplicated values (except first occurrence) in a Collection, based on a <code>Comparator</code>. <code>Comparator</code> is used to specify the field of an object to be used as reference for duplicate checking
* <code>Set<O> *getUnique*(Collection<O> list, Comparator<? super O> comparator)</code>:   Returns Set of Unique values (and first occurrences of duplicated values) of a Collection, based on a <code>Comparator</code>

### DateUtil
Utility for performing Date-Time related operations. Primary functions are
* <code>boolean *between*(String date, String startDate, String endDate)</code>  Determines whether a date value lies in an *inclusive* range of dates. Date inputs may be provided as Strings in the format ''YYYY-MM-DD''
* <code>String *getStartDate*(String endDate, int durationInDays)</code>  Returns a date after adding a specified duration to the provided date. Thus, can be used to get the date a certain duration (duration in days) before/after the specified date
* <code>Date *getDateForMonth*(int month, int year)</code>  Convert a provided month, year pair to a <code>*Date*</code> object (Assuming first day of month). Months are indexed from 0, i.e. 0-January, 11-December
* <code>LocalDate *getLocalDateForMonth*(int month, int year)</code>  Convert a provided month, year to <code>*LocalDate*</code> object (Assuming first day of month). Months are indexed from 1, i.e.1-January, 12-December

### CryptoUtil
Utility to perform Encryption of Strings using AES Encryption. By Default, uses AES, 128 bit, ECB mode encryption with UTF-8 output encoding
* <code>String *encrypt*(String plaintext, String keyStr)</code>  Encrypt a <code>plaintext</code> input String with <code>keyStr</code> used as key through AES encryption. Returns the encrypted text string
* <code>String *decrypt*(String ciphertext, String keyStr)</code>  Decrypts a <code>ciphertext</code> string encrypted through AES using <code>keyStr</code> as key

### CmdUtil
Allows the execution of operating system processes through provided commands. Primary methods are
* <code>void *runCmd*(String[] cmd, Redirect out, Redirect error)</code>  Runs an operating system command. cmd is the list of Strings signifying external program to execute along with its arguments (if any). out and error parameters denote the destination of process output/error. E.g. to get the Java version, we can ran the <code>java -version</code> command as follows  <code>CmdUtil.runCmd(new String[]{"*''java*''", "-*''version*''"}, ProcessBuilder.Redirect.INHERIT, ProcessBuilder.Redirect.INHERIT);</code>

### EvalEngine
Allows evaluation/execution of a script in ECMAScript/Javascript through Java
* <code>ScriptEngine *getEngine*()</code>: Returns a ScriptEngine for executing Javascript code
* <code>Object *eval*(String script)</code>: Evaluates/Executes a provided JS Script and returns value returned on execution of script
* <code>Object *eval*(String script, Map<String, String> params)</code>: Evaluates/Executes a provided JS Script ''with params''

### FileUtil
Allows creation/deletion of temporary files and directories through the folllowing methods
* <code>File *getTempDir*(String dirName)</code>: Create a temporary directory with the specified name in the ''JAVA_TEMP_DIR'' location (if file doesn't already exists). The directory is created in-memory and temporarily.
* <code>File *createTempFile*(File dir, String fileName)</code>: Create a temporary, in-memory file with given filename in the specified directory
* <code>File *createTempFileWithExt*(File dir, String ext)</code>: Create a temporary, in-memory file using just the extension (assigns random name) in specified directory
* <code>void *deleteFile*(String filePath)</code>: Quietly delete a file

## FileFormatUtil
Converts a TSV (Tab Separated Value) File into a CSV File (ignoring the first row). Primary methods are
* <code>void *tsvToCsv*(File tsvFile, File csvFile)</code>: Converts a TSV file into a CSV file

## Interner
<code>Interner</code> allows the creation of a list of lists for containing arbitrary Objects. Each sub-list is referred to as a <code>Bucket</code> and has a maximum load that it can contain. The <code>Interner</code> may be instantiated by passing the two constructor arguments, <code>*capacity*</code> and <code>*load*</code>. The <code>capacity</code> specifies the total number of objects to be accommodated and the <code>load</code> specifies the maximum size per bucket (by default, <code>capacity=256</code>, <code>load=16</code>). Objects are inserted into a Bucket arbitrarily based on their hash code values. To insert an object into one of the Buckets, the following method is used
* <code>T *intern*(T t)</code>: Insert an element into a bucket based on Object's hash code. If object already exists, returns it

## TimerUtil
A Timer Class that allows measurement of time duration through the following methods
* <code>void *start*()</code>: Start a timer
* <code>void *stop*()</code>: Stop the timer
* <code>long *getDuration*()</code>: Get elapsed time between start and stop in milliseconds

## License
Copyright (c) Increff

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing permissions and limitations under
the License.