# safer-pool

## Ausgangssituation
Im Jahr 2018 wurden etwas mehr als 85.000 Kinder in Österreich geboren. Vor allem im Sommer spielen die Kinder, wenn möglich draußen in der Sonne. In Österreich gibt es immer mehr Haushalte mit einem Swimming-Pool im Garten. Laut der letzten Auswertung des Landes Oberösterreich gibt es in etwa 61.000 Pools in Oberösterreich, jedoch kann aktuell mit einer höheren Zahl gerechnet werden da die Zahl stetig steigt. Viele Familien genießen ihre heißen Sommertage gemeinsam am Pool und erfreuen sich an der Abkühlung im Nass.

## Ist-Sitation
Es ist fast unmöglich Kinder lückenlos zu beaufsichtigen, da einen jeder noch so kleine Umstand ablenken kann. Beispiele für solche Ablenkungen wären ein Anruf oder auch ein kurzer Gang ins Haus, um etwas zu holen.

## Problem
Auch wenn die Zeit, in der die Kinder unbeaufsichtigt sind, noch so kurz ist kann es dadurch sehr schnell zu Badeunfällen kommen.

## Aufgabenstellung 
Es ist ein System zu entwickeln, dass Objekte detektiert, die in den Pool fallen. Das müssen in erster Linie nicht nur Kleinkinder, sondern können auch Haustiere oder ein Ball, mit dem das Kind gerade spielt sein. Sobald solch eine Detektion durch das System erfolgt wird sowohl ein auditives wie auch visuelles Signal abgegeben werden.

Die Detektion kann auch für eine gewisse Zeitdauer deaktiviert werden, wen man bewusst schimmen gehen möchte. Nebenbedingungen wie ein Stromausfall, Sensorausfall etc. werden ebenso erkannt.

Das aktuell geplante System tastet sich vorerst nur an einen Prototypen heran. Es sollte möglichst ausfallsicher und einfach zu installieren sein. Wünschenswert wäre, wenn die Stromzufuhr möglichst nachhaltig wäre, daher wollen wir auf klassische Batterien verzichten und stattdessen wiederaufladbare Batterien verwenden. Ein Betrieb durch Solarstrom ist bei diesem geringen Verbrauch auszuschließen, da man zu viel Zusatz-Material benötigt.

## Anwendungsfälle
![Use-Case-Diagramm](https://raw.githubusercontent.com/KonstantinFrank01/safer-pool/master/Assets/use_case_diagram.png)

## Systemarchitektur
![Systemarchitektur](https://raw.githubusercontent.com/KonstantinFrank01/safer-pool/master/Assets/systemarchitektur.jpg)

## Youtrack Diagramm
![Youtrack-Diagramm](https://raw.githubusercontent.com/KonstantinFrank01/safer-pool/master/Assets/youtrack-diagram-netunus.png)

## Zielsetzung
Das klare Ziel dieser Anwendung ist es Kinder sowie Haustiere vor Badeunfällen zu bewahren. Wie schon erwähnt wird das System möglichst nachhaltig betrieben werden. Es wird ebenfalls eine App zur noch schnelleren Benachrichtigung und angenehmerer Benutzung des Systems entwickelt werden.
