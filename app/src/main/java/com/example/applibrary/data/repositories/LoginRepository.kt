package com.example.applibrary.data.repositories

import com.example.applibrary.R
import com.example.applibrary.USER_COLLECTION
import com.example.applibrary.data.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await

class LoginRepository(private val auth: FirebaseAuth, private val db: FirebaseFirestore){
    suspend fun login(email: String, password: String){
        try{
            auth.signInWithEmailAndPassword(email, password).await()
        }catch (e: FirebaseAuthException){
            throw Exception(e.message)
        }
    }

    suspend fun signUp(documento: String, name: String, email: String, password: String){
        try{
            auth.createUserWithEmailAndPassword(email, password).await()
            val user = auth.currentUser!!
            user.updateProfile(userProfileChangeRequest {
                displayName = name
            }).await()
            val userInfo = hashMapOf(
                "documento" to documento
            )
            db.collection(USER_COLLECTION).document(user.uid).set(userInfo).await()
        }catch (e: FirebaseAuthException){
            throw Exception(e.message)
        }
    }

    suspend fun currentUser(): UserModel{
        /*return UserModel("1", "Kevin Jimenez",
            "kevin@gmail.com","Masculino",
            R.drawable.ic_baseline_person_24.toString())*/
        val user = auth.currentUser
        if(user != null){
            val info = db.collection(USER_COLLECTION).document(user.uid).get().await()
            return UserModel(user.uid, user.displayName!!, user.email!!, info.get("documento").toString(), R.drawable.ic_baseline_person_24.toString())
        }else{
            throw Exception("Usuarion no encontrado")
        }
    }

    suspend fun logOut(){
        auth.signOut()
    }
}