<form:form action="/wizard.form?_page=3" method="post" modelAttribute="modelWizard">
    <form:label path="step2">Créer un devis habitation - Étape 2 : </form:label>
    <div><label>Nombre de pièces : <input type="text" name="nbRooms"/></label></div>
    <div><label>Étage : <input type="text" name="floor"/></label></div>
    <div><label>Nombre de salles de bain : <input type="text" name="nbBathrooms"/></label></div>
    <div><label>Garage : <input type="radio" value="yes"/>Oui<input type="radio" value="no"/>Non</label></div>
    <form:input path="step2" />
    <input type="submit" value="Aller à l'étape 3" />
</form:form>