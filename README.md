# GeRuMap - GUI Mind Mapping Application
It was developed in Java using Swing as part of the [Software Design](https://raf.edu.rs/en/subjects/software-design/) pair assignment. It features an intuitive interface for creating, drawing, editing and sharing mind maps. Mind Maps can be grouped into a project and saved or exported.

[Documentation (Serbian)](https://cake-hearing-30b.notion.site/GeRuMap-93e033bfb3b14be0a41cf7dcd5198e69) <br>
[Sequence Diagram](https://cake-hearing-30b.notion.site/Dijagram-Sekvence-1e565fa1a911452186fe98e322fed329)
***

## Design Patterns
* Singleton
* Observer
* Command
* Composite
* Factory
* State

## Features
* Create/Open/Save/Rename Projects
* Mind Map can be exported into PNG
* Author can be set for a project
* Includes a Graphical editor with it's own set of features
    * Selection Tool
    * Move Tool
    * Zoom Tool
    * Add Concept Tool
    * Connection Tool
    * Eraser Tool
    * Settings (style editor)
    * Central Concept Tool
        (Centers and enlarges concept and uses BFS to map all other concepts around it)
* Undo/Redo implemented using Command Pattern
* Includes Templating system. Maps can be saved as a template and it's content can be imported into any map later.

# Running
You can clone the repository and run AppCore class or download one of the releases. You need java version 17 or later.

## Windows
There is a .exe release which is recommended. If that doesn't work you can use .jar as well.
## MacOS
There is a known problem of how Apple treats "unidentified developers" You have to disable GateKeeper if you want to use .jar from the releases page. If you choose to do so, follow the linux guide below.
## Linux
Download .jar from releases and cd into the directory.
```
java -jar gerumap-v1.0.jar
```
You can also run .exe with wine if you, for some reason, want to do that.

# Screenshots
!(home page)[https://imgur.com/dqiU6x9.jpg]

!(editing map)[https://imgur.com/qCcKL2z.jpg]

!(concept settings)[https://imgur.com/pdFAqm4.jpg]


***
## Authors
* Marko Kocic 99/22 RN
* Danilo Joncic 141/22 RN
