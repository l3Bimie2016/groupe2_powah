<form:form action="/wizard.form?_finish=1" method="post" modelAttribute="modelWizard">
    <form:label path="step4">Créer un devis habitation - Étape 4 : </form:label>
    <div>Résumé : </div>
    <div><label>Formule : <input type="radio" value="1"/>1<input type="radio" value="2"/>2</label></div>
    <div>Prix : </div>
    <form:input path="step4" />
    <input type="submit" value="Finaliser" />
</form:form>